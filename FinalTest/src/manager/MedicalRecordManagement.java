package manager;

import medicalrecord.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeParseException;

public class MedicalRecordManagement {
    private List<MedicalRecord> medicalRecords;
    private Scanner scanner;
    private static final String FILE_PATH = "medical_records.csv";

    public MedicalRecordManagement() {
        medicalRecords = new ArrayList<>();
        scanner = new Scanner(System.in);
        loadMedicalRecordsFromCSV();
    }

    private void loadMedicalRecordsFromCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 6) {
                    System.err.println("Dữ liệu không hợp lệ: " + line);
                    continue;
                }

                int serialNumber = Integer.parseInt(parts[0].trim());
                String recordCode = parts[1].trim();
                String patientName = parts[2].trim();
                LocalDate admissionDate = LocalDate.parse(parts[3].trim(), MedicalRecord.DATE_FORMATTER);
                LocalDate dischargeDate = LocalDate.parse(parts[4].trim(), MedicalRecord.DATE_FORMATTER);
                String admissionReason = parts[5].trim();

                if (recordCode.startsWith("BA")) {
                    if (parts.length < 7) {
                        System.err.println("Dữ liệu không hợp lệ: " + line);
                        continue;
                    }
                    double hospitalFee = Double.parseDouble(parts[6].trim());
                    medicalRecords.add(new NormalMedicalRecord(serialNumber, recordCode, patientName,
                            admissionDate, dischargeDate, admissionReason, hospitalFee));
                } else if (recordCode.startsWith("VIP")) {
                    if (parts.length < 8) {
                        System.err.println("Dữ liệu không hợp lệ: " + line);
                        continue;
                    }
                    String vipType = parts[6].trim();
                    LocalDate vipEndDate = LocalDate.parse(parts[7].trim(), MedicalRecord.DATE_FORMATTER);
                    medicalRecords.add(new VIPMedicalRecord(serialNumber, recordCode,
                            patientName, admissionDate, dischargeDate, admissionReason, vipType, vipEndDate));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Không tìm thấy tệp medical_records.csv: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc tệp medical_records.csv: " + e.getMessage());
        } catch (DateTimeParseException e) {
            System.err.println("Lỗi định dạng ngày trong dữ liệu bệnh án: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Lỗi định dạng số trong dữ liệu bệnh án: " + e.getMessage());
        }
    }

    private void saveMedicalRecordsToCSV() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (MedicalRecord record : medicalRecords) {
                bw.write(record.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi lưu dữ liệu bệnh án: " + e.getMessage());
        }
    }

    public void addMedicalRecord() {
        System.out.println("Nhập thông tin cho bệnh án mới:");

        int serialNumber = medicalRecords.isEmpty() ? 1 : medicalRecords.get(medicalRecords.size() - 1).getSerialNumber() + 1;

        System.out.print("Mã bệnh án (VD: BA-001 hoặc VIP-001): ");
        String recordCode = scanner.nextLine().trim();

        System.out.print("Tên bệnh nhân: ");
        String patientName = scanner.nextLine().trim();

        System.out.print("Ngày nhập viện (dd/MM/yyyy): ");
        LocalDate admissionDate = readLocalDate();

        System.out.print("Ngày ra viện (dd/MM/yyyy): ");
        LocalDate dischargeDate = readLocalDate();

        System.out.print("Lý do nhập viện: ");
        String admissionReason = scanner.nextLine().trim();

        if (recordCode.startsWith("BA")) {
            System.out.print("Phí nằm viện: ");
            double hospitalFee = scanner.nextDouble();
            scanner.nextLine();
            medicalRecords.add(new NormalMedicalRecord(serialNumber, recordCode, patientName,
                    admissionDate, dischargeDate, admissionReason, hospitalFee));
        } else if (recordCode.startsWith("VIP")) {
            System.out.print("Loại VIP (VIP I, VIP II, VIP III): ");
            String vipType = scanner.nextLine().trim();

            System.out.print("Ngày hết hạn VIP (dd/MM/yyyy): ");
            LocalDate vipEndDate = readLocalDate();

            medicalRecords.add(new VIPMedicalRecord(serialNumber, recordCode,
                    patientName, admissionDate, dischargeDate, admissionReason, vipType, vipEndDate));
        }

        saveMedicalRecordsToCSV();
        System.out.println("Thêm bệnh án thành công.");
    }

    private LocalDate readLocalDate() {
        LocalDate date = null;
        boolean valid = false;
        while (!valid) {
            try {
                String input = scanner.nextLine().trim();
                date = LocalDate.parse(input, MedicalRecord.DATE_FORMATTER);
                valid = true;
            } catch (Exception e) {
                System.out.print("Định dạng ngày không hợp lệ. Vui lòng nhập lại (dd/MM/yyyy): ");
            }
        }
        return date;
    }

    public void deleteMedicalRecord() {
        System.out.print("Nhập mã bệnh án cần xóa: ");
        String recordCode = scanner.nextLine().trim();

        boolean found = false;
        for (MedicalRecord record : medicalRecords) {
            if (record.getRecordCode().equals(recordCode)) {
                found = true;
                System.out.println("Bệnh án được tìm thấy:");
                System.out.println(record);
                System.out.print("Xác nhận xóa (Có/Không): ");
                String confirm = scanner.nextLine().trim();
                if (confirm.equalsIgnoreCase("Có")) {
                    medicalRecords.remove(record);
                    saveMedicalRecordsToCSV();
                    System.out.println("Xóa bệnh án thành công.");
                } else {
                    System.out.println("Hủy xóa.");
                }
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy bệnh án có mã " + recordCode + ".");
        }
    }

    public void displayMedicalRecords() {
        if (medicalRecords.isEmpty()) {
            System.out.println("Không tìm thấy bệnh án nào.");
        } else {
            System.out.println("Danh sách bệnh án:");
            for (MedicalRecord record : medicalRecords) {
                System.out.println(record);
                System.out.println("================================");
            }
        }
    }

    public void mainMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nHệ thống quản lý bệnh án");
            System.out.println("1. Thêm mới bệnh án");
            System.out.println("2. Xóa bệnh án");
            System.out.println("3. Xem danh sách bệnh án");
            System.out.println("4. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addMedicalRecord();
                    break;
                case 2:
                    deleteMedicalRecord();
                    break;
                case 3:
                    displayMedicalRecords();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        }
        System.out.println("Đang thoát khỏi hệ thống quản lý bệnh án. Tạm biệt!");
        scanner.close();
    }

    public static void main(String[] args) {
        MedicalRecordManagement management = new MedicalRecordManagement();
        management.mainMenu();
    }
}
