
import java.io.*;
import java.util.Scanner;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;

public class Main {
    public static void AddFolder(String folderName) {
        try {
            File folder = new File(folderName);
            if (!folder.exists()) {
                folder.mkdir();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void AddFileInFolder(String folderName, String fileName) {
        try {
            File folder = new File(folderName);
            if (!folder.exists()) {
                folder.mkdir();
            }
            File file = new File(folder.getAbsolutePath() + "/" + fileName + ".txt");
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void ReedFile(String folderName, String fileName) throws IOException {
        File myFile = new File(folderName,fileName);
        FileInputStream inputStream = new FileInputStream(myFile);
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            System.out.println(new String(buffer, 0, bytesRead));
        }
        inputStream.close();}

    public static void ReedFolder(String folderName1) throws IOException {
            // определяем объект для каталога
            File dir = new File(folderName1);
            // если объект представляет каталог
            if(dir.isDirectory())
            {
                // получаем все вложенные объекты в каталоге
                for(File item : dir.listFiles()){

                    if(item.isDirectory()){

                        System.out.println(item.getName() + "  \t folder");
                    }
                    else{

                        System.out.println(item.getName() + "\t file");
                    }
                }
            }
        }

        public static void UpdateFile (String folderName2, String fileName2, String updateData) throws IOException {
            File myFile2 = new File(folderName2,fileName2);
            FileOutputStream outputStream = new FileOutputStream(myFile2);
            byte[] buffer = updateData.getBytes();
            outputStream.write(buffer);
            outputStream.close();
        }

        public static void deleteFolderAndFileInFolder (String folderName4, String fileName4) {
        try {
            File folder = new File(folderName4);
            if (folder.isDirectory()) {
                File file = new File(folderName4, fileName4);
                if (file.isFile()) {
                    System.out.println("Delete file : " + file.delete());
                }
                System.out.println("Delete folder : " + folder.delete());
            } else {
                System.out.println("Ok");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }}

    public static void CreateXml (String firstname1, String lastname1, String nickname1,
    String salary1){
        try {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();


        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element rootElement = document.createElement("company");
        document.appendChild(rootElement);

        Element staff = document.createElement("staff");
        rootElement.appendChild(staff);

        Attr attr = document.createAttribute("id");
        attr.setValue("1");
        staff.setAttributeNode(attr);
        staff.setAttribute("key","value");

        Element firstname = document.createElement("firstname");
        firstname.appendChild(document.createTextNode(firstname1));
        staff.appendChild(firstname);

        Element lastname = document.createElement("lastname");
        lastname.appendChild(document.createTextNode(lastname1));
        staff.appendChild(lastname);

        Element nickname = document.createElement("nickname");
        nickname.appendChild(document.createTextNode(nickname1));
        staff.appendChild(nickname);

        Element salary = document.createElement("salary");
        salary.appendChild(document.createTextNode(salary1));
        staff.appendChild(salary);


        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);


        File file1 = new File("create.xml");
        StreamResult streamResult = new StreamResult(file1);
        transformer.transform(domSource,streamResult);
    }catch (Exception e) {
        System.out.println(e.getMessage());
    }
    }


    public static String mScanerString() {
        String k = null;
        Scanner scanner = new Scanner(System.in);
        boolean isString = scanner.hasNextLine();
        if (isString) k = scanner.nextLine();
        {
            return k;
        }
    }
    public static int mScanerInt() throws Exception {
        int k = 0;
        Scanner scanner = new Scanner(System.in);
        boolean isInt = scanner.hasNextInt();
        if (isInt) k = scanner.nextInt();
        if (k >= 1 & k <= 10) {
            return k;
        }
        throw new Exception("Ввести нужно только число число от 1 до 10, буквы вводить нельзя");
    }

    public static void main(String[] args) throws Exception {
        int m = 0;
        String k = null;
        Scanner scanner = new Scanner(System.in);


        do {
            System.out.println("Добро пожаловать!\nВыберите пункт меню:" );
            System.out.println("1. Создать папку");
            System.out.println("2. Создать файл");
            System.out.println("3. Посмотреть содержимое папки");
            System.out.println("4. Прочитать содержимое файла");
            System.out.println("5. Редактировать файл");
            System.out.println("6. Удалить папку и файлы в ней");
            System.out.println("7. Создать файл xml");
            System.out.println("8. Выход");

            m = Main.mScanerInt();
            switch (m) {
                case 1:
                    System.out.println("Ввдите название папки, которую хотите создать");
                    String newFolderName = scanner.nextLine();
                    AddFolder(newFolderName);
                    break;
                    case 2:
                    System.out.println("Ввдите название папки в которой хотите создать файл и название самого файла, который хотите создать");
                        String folderName = scanner.nextLine();
                        String fileName = scanner.nextLine();

                    AddFileInFolder(folderName, fileName);
                    break;
                    case 3:
                        System.out.println("Ввдите название папки в которой хотите посмотреть содержимое");
                        String reedFolderName1 = scanner.nextLine();
                        ReedFolder(reedFolderName1);
                        break;
                    case 4:
                        System.out.println("Ввдите название папки в которой хотите прочитать файл и название самого файла, который хотите прочитать");
                        String reedFolderName = scanner.nextLine();
                        String reedFileName = scanner.nextLine();
                        ReedFile(reedFolderName, reedFileName);
                        break;
                        case 5:
                        System.out.println("Ввдите название папки и название самого файла, который хотите отредактировать/n , " +
                                "а затем введите новую информацию, которую хотите добавить в файл");
                        String reedFolderName2 = scanner.nextLine();
                        String reedFileName2 = scanner.nextLine();
                        String updateData = scanner.nextLine();
                        UpdateFile(reedFolderName2, reedFileName2, updateData);
                        break;
                        case 6:
                        System.out.println("Ввдите название папки и название файлов в ней, которые хотите удалить");
                        String reedFolderName4 = scanner.nextLine();
                        String reedFileName4 = scanner.nextLine();
                        deleteFolderAndFileInFolder(reedFolderName4, reedFileName4);
                        break;
                        case 7:
                        System.out.println("Ввдите данные для файла xml: \n" +
                                "данные вводите такие:\n" +
                                "Фамилия \n" +
                                "Имя\n" +
                                "Ник\n" +
                                "зарплата");
                        String fistname1 = scanner.nextLine();
                        String lastname1 = scanner.nextLine();
                        String nickname1 = scanner.nextLine();
                        String salary1 = scanner.nextLine();
                        CreateXml(fistname1, lastname1,nickname1, salary1);
                            System.out.println("Ваш файл xml создан");
                        break;
                case 8:
                            System.out.println("До свидания!");
                            System.exit(0);
                            break;
            }
        } while (true);
    }}


