package main.java;

public enum NivelTecnico {
    JUNIOR(1),
    SEMI_SENIOR(2),
    SENIOR(3);

    private final int jerarquia;

    NivelTecnico(int jerarquia) {
        this.jerarquia = jerarquia;
    }

    public int getJerarquia() { return jerarquia; }
}
