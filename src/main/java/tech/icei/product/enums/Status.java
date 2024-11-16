package tech.icei.product.enums;

public enum Status {
    ACT("Activo"), INA("Inactivo"), ELI("Eliminado");

    private String statusValue;

    Status(String statusValue) {
        this.statusValue = statusValue;
    }

    public String getStatusValue() {
        return statusValue;
    }
}
