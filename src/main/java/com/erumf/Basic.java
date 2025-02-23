package com.erumf;

public abstract class Basic {
    private final Player player;

    public Basic(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    /**
     * TODO: IMPLEMENTAR UNA COLECCIÓN DE LISTENERS CON TIPO: IN, EXEC, OUT Y UN EVENTO ASOCIADO
     * CUANDO SE AÑADE UN LISTENER DE UN EVENTO ASOCIADO AUTOMATICAMENTE EN ESTA CLASE SE DEBE
     * AÑADIR A LA COLECCIÓN DE LISTENERS DE ESA CLASE DE EVENTO
     * 
     * 
     * TODO: dividir las fases de forma programática, en eventos que se siguen unos detrás de otros??
     */
}