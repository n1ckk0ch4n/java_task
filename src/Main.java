import controller.CmdController;
import repository.Repo;
import service.ArchiveService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Repo repo = new Repo();
        ArchiveService service = new ArchiveService(repo);
        Scanner scanner = new Scanner(System.in);

        CmdController controller = new CmdController(scanner, service);
        controller.run();
    }
}