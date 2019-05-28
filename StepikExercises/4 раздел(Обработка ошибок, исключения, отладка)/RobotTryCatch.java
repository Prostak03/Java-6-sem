/*
�������� ������ ������� ��������� ������ �� ���� ������. ������ �� ����� ������ ������ ������� ��������, ����������� � ���� �� ������������� ������ �����.

����������� � ������ �������������� � ��������� ����������� RobotConnection:

public interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y);
    @Override
    void close();
}
��, ����� � ��� ��� ������� � ���� �������� ������� �� ����������� � �������� ����� (����� moveRobotTo). ��� ������ �� ����� ��������� ����������.
RobotConnection � ��� �������� ��������������� ����������, ������� ���� ���������, ����� ��� ������ �� �����. ��� �������� ���������� � ���������� ���� ����� close().

�� ��������� ���������� �������� RobotConnectionManager:

public interface RobotConnectionManager {
    RobotConnection getConnection();
}
����� getConnection() ������ ������� ����������� � ������� � ���������� ������������� ����������, ����� ������� ����� �������� ������ �������.
��������� ���������� ����� ����������� ���������, � ����� ��� ������������� ���������� ����� �������� �����������. ������ ������. ������� ����� ����� RobotConnectionManager � RobotConnection ����� ������� ���������� RobotConnectionException:

public class RobotConnectionException extends RuntimeException {

    public RobotConnectionException(String message) {
        super(message);

    }

    public RobotConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
���� ������ � ����������� ����� ������� ������������� ���������� � �������, ������ ��� ������� �� ����������� � �������� ����� � ����� ��������� ����������, �������� ��� ������������� ������ ���� ������������������ �� ���� ���.

��� ����:

������� ������ ������� ������ ��������� ��������, ���� ������� ���������� ���������� � ��������� ����� RobotConnection.moveRobotTo() ��� ����������. ������ �������� ���������� �� ����� � ������ ��������������.
���� ������ ������� ������������ � ������ ������� ��������� ����������, �� ��������� ���������� � ��������� ������ �������. ���� ������ ���� �� �������, �� ����������� ������. ����� ������� ������� ����� ������ ������� ���������� RobotConnectionException.
����� �������� �� �������� � �������� ����������. ���� ���������� ������� ����������, �� ��� ����������� ������ ���� ������� �������� �� ��������� ����������, ����������� � ���������� �� ����� ������ ������.
���� �� ����� ������ ������ ��������� ���������� ������ ����, ��������� �� RobotConnectionException, ����� ������ ����������� � ��������� ��� ����������, �� �������� ��������� ������� ���������� � �������. ������������, ��� ����� ������ ������� ����� �������� ����� ���������� � ������� �������� ���������� RobotConnection.
*/
public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
    boolean success = false;
    for (int i = 0; !success && (i < 3); ++i) {
        try (RobotConnection connection = robotConnectionManager.getConnection()) {
            connection.moveRobotTo(toX, toY);
            success = true;
        } catch (RobotConnectionException e) {}
    }
    if (!success) {
        throw new RobotConnectionException("3 attempts failed");
    }
}