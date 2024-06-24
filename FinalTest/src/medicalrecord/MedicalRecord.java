package medicalrecord;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class MedicalRecord {
    protected int serialNumber;
    protected String recordCode;
    protected String patientName;
    protected LocalDate admissionDate;
    protected LocalDate dischargeDate;
    protected String admissionReason;


    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public MedicalRecord(int serialNumber, String recordCode, String patientName,
                         LocalDate admissionDate, LocalDate dischargeDate, String admissionReason) {
        this.serialNumber = serialNumber;
        this.recordCode = recordCode;
        this.patientName = patientName;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.admissionReason = admissionReason;
    }

    public abstract String toCSV();

    public int getSerialNumber() {
        return serialNumber;
    }

    public String getRecordCode() {
        return recordCode;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public String getAdmissionReason() {
        return admissionReason;
    }

    @Override
    public String toString() {
        return "Số thứ tự: " + serialNumber + "\n" +
                "Mã hồ sơ: " + recordCode + "\n" +
                "Ngày nhập viện: " + admissionDate.format(DATE_FORMATTER) + "\n" +
                "Ngày ra viện: " + dischargeDate.format(DATE_FORMATTER) + "\n" +
                "Lý do nhập viện: " + admissionReason + "\n" +
                "Tên bệnh nhân: " + patientName;
    }
}
