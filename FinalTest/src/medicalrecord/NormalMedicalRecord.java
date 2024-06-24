package medicalrecord;

import java.time.LocalDate;

public class NormalMedicalRecord extends MedicalRecord {
    private double hospitalFee;

    public NormalMedicalRecord(int serialNumber, String recordCode, String patientName, LocalDate admissionDate, LocalDate dischargeDate, String admissionReason, double hospitalFee) {
        super(serialNumber, recordCode, patientName, admissionDate, dischargeDate, admissionReason);
        this.hospitalFee = hospitalFee;
    }

    public double getHospitalFee() {
        return hospitalFee;
    }

    @Override
    public String toCSV() {
        return serialNumber + "," + recordCode + "," + patientName + "," + admissionDate + "," + dischargeDate + "," + admissionReason + "," + hospitalFee;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Phí viện phí: " + hospitalFee;
    }
}
