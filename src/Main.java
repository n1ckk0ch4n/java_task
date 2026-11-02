import controller.CmdController;
import repository.ArchiveRepo;
import repository.FileRepo;
import service.ArchiveService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArchiveRepo archiveRepo = new ArchiveRepo();
        FileRepo fileRepo = new FileRepo();
        ArchiveService service = new ArchiveService(archiveRepo, fileRepo);
        Scanner scanner = new Scanner(System.in);
        CmdController controller = new CmdController(scanner, service);
        controller.run();
    }
}