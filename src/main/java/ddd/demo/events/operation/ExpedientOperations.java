package ddd.demo.events.operation;

public enum ExpedientOperations {

    INGRESO,
    INICIAR_INGRESO(INGRESO), // SUBTAREAS
    FINALIZAR_INGRESO(INGRESO); // SUBTAREAS

    ExpedientOperations parent;

    ExpedientOperations() {
    }

    ExpedientOperations(ExpedientOperations parent) {
        this.parent = parent;
    }

    public ExpedientOperations parent() {
        return parent;
    }
}
