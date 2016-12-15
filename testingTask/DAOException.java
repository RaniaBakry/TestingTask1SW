package testingTask;
public class DAOException extends Exception{
	DAOException(Throwable e){
		super("This exception is produced from a DAO Component",e);
	}
}
