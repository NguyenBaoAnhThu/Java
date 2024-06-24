package medicalrecord;

import java.time.LocalDate;

public class VIPMedicalRecord extends MedicalRecord {
    private String vipType;
    private LocalDate vipEndDate;

    public VIPMedicalRecord(int serialNumber, String recordCode, String patientName,
                            LocalDate admissionDate, LocalDate dischargeDate,
                            String admissionReason, String vipType, LocalDate vipEndDate) {
        super(serialNumber, recordCode, patientName, admissionDate, dischargeDate, admissionReason);
        this.vipType = vipType;
        this.vipEndDate = vipEndDate;
    }

    public String getVipType() {
        return vipType;
    }

    public LocalDate getVipEndDate() {
        return vipEndDate;
    }

    @Override
    public String toCSV() {
        return String.format("%d,%s,%s,%s,%s,%s,%s,%s",
                serialNumber, recordCode, patientName,
                admissionDate.format(DATE_FORMATTER), dischargeDate.format(DATE_FORMATTER),
                admissionReason, vipType, vipEndDate.format(DATE_FORMATTER));
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Loại VIP: " + vipType + "\n" +
                "Ngày hết hạn VIP: " + vipEndDate.format(DATE_FORMATTER);
    }
}
