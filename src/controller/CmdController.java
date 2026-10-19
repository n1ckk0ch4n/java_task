package controller;

import model.Archive;
import model.File;
import service.ArchiveService;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class CmdController {
    private final Scanner scanner;
    private final ArchiveService archiveService;

    public CmdController(Scanner scanner, ArchiveService archiveService) {
        this.scanner = scanner;
        this.archiveService = archiveService;
    }

    public void run() {
        while (true) {
            System.out.println("\nАрхивы");
            System.out.println("1.Все архивы");
            System.out.println("2.Содержимое");
            System.out.println("3.Создать архив");
            System.out.println("4.Переименовать архив");
            System.out.println("5.Удалить архив");
            System.out.println("6.Добавить файл в архив");
            System.out.println("7.Удалить файл из архива");
            System.out.println("0.Выход");
            System.out.print("Выбор: ");

            String command = scanner.nextLine();

            try {
                switch (command) {
                    case "1" -> showAll();
                    case "2" -> showById();
                    case "3" -> create();
                    case "4" -> update();
                    case "5" -> delete();
                    case "6" -> addFile();
                    case "7" -> removeFile();
                    case "0" -> {
                        System.out.println("Выход");
                        return;
                    }
                    default -> System.out.println("Неверная команда");
                }
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    private void showAll() {
        List<Archive> all = archiveService.getAll();
        if (all.isEmpty()) {
            System.out.println("Архивов нет");
            return;
        }
        all.forEach(a -> System.out.println(formatArchive(a)));
    }

    private void showById() {
        UUID id = getUUID();
        Archive archive = archiveService.getById(id);
        System.out.println("Архив: " + archive.getName() + " (создан: " + archive.getCreatedAt() + ")");
        if (archive.getFiles().isEmpty()) {
            System.out.println("Файлов нет");
        } else {
            for (File f : archive.getFiles()) {
                System.out.println(f.getName() + "ID: " + f.getId());
            }
        }
    }

    private void create() {
        System.out.print("Введите наименование архива:");
        String name = scanner.nextLine();
        Archive a = archiveService.create(name);
        System.out.println("Успешно создано:" + formatArchive(a));
    }

    private void update() {
        UUID id = getUUID();
        System.out.print("Введите новое наименование архива:");
        String newName = scanner.nextLine();
        Archive updated = archiveService.update(id, newName);
        System.out.println("Архив обновлен:" + formatArchive(updated));
    }

    private void delete() {
        UUID uuid = getUUID();
        archiveService.deleteById(uuid);
        System.out.println("Успешно удалено с идентификатором " + uuid);
    }

    private void addFile() {
        UUID archiveId = getUUID();
        System.out.print("Введите имя файла:");
        String fileName = scanner.nextLine();
        System.out.print("Введите текст файла:");
        String content = scanner.nextLine();
        archiveService.addFile(archiveId, fileName, content);
        System.out.println("Файл добавлен в архив");
    }

    private void removeFile() {
        UUID archiveId = getUUID();
        System.out.print("Введите ID файла для удаления: ");
        UUID fileId = UUID.fromString(scanner.nextLine());
        archiveService.removeFile(archiveId, fileId);
        System.out.println("Файл удален из архива");
    }

    private UUID getUUID() {
        while (true) {
            System.out.print("Введите ID:");
            try {
                return UUID.fromString(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println("Неверный формат ID.Попробуйте снова.");
            }
        }
    }

    private String formatArchive(Archive archive) {
        return "ID: " + archive.getId() + "Название: " + archive.getName() +
                "Файлов: " + archive.getFiles().size();
    }
}