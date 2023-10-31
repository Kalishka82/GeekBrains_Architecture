import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

/**
 * Необходимо разделить на горизонтальные уровни "Редактор 3D графики"
 * Один пользователь. Программа работает на одном компьютере без выхода в сеть.
 *
 * Что видит пользователь, как взаимодействует? (Панель загрузки, блок редактирования,
 * блок просмотра).
 * Какие задачи можно делать - функции системы? (Загрузить модель, рассмотреть, создать
 * новую, редактировать вершины, текстуры, сделать рендер, сохранить рендер).
 * Какие и где хранятся данные? (файлы моделей, рендеры, анимация ..., в файловой
 * системе компьютера).
 *
 * Предложить варианты связывания всех уровней - сценарии использования. 3-4 сценария
 * Сквозная ф-ия - создать новую модель, сделать рендер для печати на принтере...
 */
public class Program {
    public static void main(String[] args) {
        Editor3D editor3D = new Editor3D();
        Scanner scanner = new Scanner(System.in);
        boolean f = true;
        while (f) {
            System.out.println("*** MY 3D EDITOR ***");
            System.out.println("====================");
            System.out.println("1. Open project");
            System.out.println("2. Save project");
            System.out.println("3. Show project parameters");
            System.out.println("4. Show all project models");
            System.out.println("5. Show all project textures");
            System.out.println("6. Add model in project");
            System.out.println("7. Delete model from project");
            System.out.println("8. Add texture in project");
            System.out.println("9. Delete texture from project");
            System.out.println("10. Render all project models");
            System.out.println("11. Render model");
            System.out.println("0. CLOSE THE APP");
            System.out.print("Please, choose menu option: ");
            if (scanner.hasNextInt()) {
                int no = scanner.nextInt();
                scanner.nextLine();
                try {
                    switch (no) {
                        case 0:
                            System.out.println("CLOSING APPLICATION...PLEASE, WAIT...");
                            f = false;
                            break;
                        case 1:
                            System.out.print("Input project file name: ");
                            String fileName = scanner.nextLine();
                            editor3D.openProject(fileName);
                            System.out.println("The project open successfully");
                            break;
                        case 3:
                            editor3D.showProjectSetting();
                            break;
                        case 4:
                            editor3D.printAllModels();
                            break;
                        case 5:
                            editor3D.printAllTextures();
                            break;
                        case 6:
                            System.out.print("Input model number or ignor it: ");
                            String modelName = scanner.nextLine();
                            Collection<Texture> textures = new ArrayList<>();
                            editor3D.addModel(modelName, textures);
                            break;
                        case 7:
                            System.out.print("Input model number: ");
                            if (scanner.hasNextInt()) {
                                int i = scanner.nextInt();
                                editor3D.deleteModel(i);
                            } else {
                                System.out.println("Model number is incorrect");
                            }
                            break;
                        case 8:
                            System.out.print("Input texture number or ignor it: ");
                            String textureName = scanner.nextLine();
                            editor3D.addTexture(textureName);
                            break;
                        case 9:
                            System.out.print("Input texture number: ");
                            if (scanner.hasNextInt()) {
                                int i = scanner.nextInt();
                                editor3D.deleteTexture(i);
                            } else {
                                System.out.println("Texture number is incorrect");
                            }
                            break;
                        case 10:
                            editor3D.renderAll();
                            break;
                        case 11:
                            System.out.print("Input model number: ");
                            if (scanner.hasNextInt()) {
                                int modelNo = scanner.nextInt();
                                scanner.nextLine();
                                editor3D.renderModel(modelNo);
                            } else {
                                System.out.println("Model number isn't correct.");
                            }
                            break;
                        default:
                            System.out.print("Choose correct menu option: ");

                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Choose correct menu option: ");
                scanner.nextLine();
            }
        }
    }
}
