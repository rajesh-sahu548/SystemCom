package HCL_MiniProject_3;

class DuplicateEnoException extends Exception {
    public DuplicateEnoException(String msg) {
        super(msg);
    }
}

class InvalidPercentageException extends Exception {
    public InvalidPercentageException(String msg) {
        super(msg);
    }
}

class EmptyFieldException extends Exception {
    public EmptyFieldException(String msg) {
        super(msg);
    }
}

class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String msg) {
        super(msg);
    }
}
