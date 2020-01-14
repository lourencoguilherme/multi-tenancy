package com.wareline.api.config.enums;

public enum DBTypeEnum {
    MAIN("1", "ROLE_ADMIN"),
    JALES("899", "JALES"),
    CLIENT_B("3", "ROLE_USER");


    private String cod;
    private String descricao;

    private DBTypeEnum(String cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public String getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static DBTypeEnum toEnum(String id) {
        if (id == null) {
            return null;
        }
        for (DBTypeEnum x : DBTypeEnum.values()) {
            if (id.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Invalid Id " + id);
    }
}
