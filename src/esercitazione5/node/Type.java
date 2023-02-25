package esercitazione5.node;

public enum Type {
    INTEGER,
    BOOLEAN,
    FLOAT,
    STRING,
    CHAR,
    VOID,
    VAR,
    NOTYPE;

    public static boolean compatibility(Type requirement, Type usage){

        if(requirement==Type.VAR && (usage==Type.STRING
                || usage==Type.CHAR
                || usage==Type.FLOAT
                || usage==Type.INTEGER
                || usage==Type.BOOLEAN)){

            return true;
        }

        if(requirement==Type.FLOAT && usage==Type.INTEGER)
            return true;

        if(requirement==Type.INTEGER && usage==Type.FLOAT)
            return true;

        return requirement == usage;
    }
}
