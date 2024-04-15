import java.util.Scanner;

public class examen {

    private static final int MAX_ESTUDIANTES = 5;
    private static String[] usuarios = new String[MAX_ESTUDIANTES];
    private static String[] contraseñas = new String[MAX_ESTUDIANTES];
    private static String[][] datosEstudiantes = new String[MAX_ESTUDIANTES][3]; // Ejemplo: nombre, carrera, edad

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Registro");
            System.out.println("2. Iniciar Sesión");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    registrarUsuario();
                    break;
                case 2:
                    iniciarSesion();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 3);
    }

    private static void registrarUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Registro de Usuario");
        System.out.print("Ingrese su nombre de usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String contraseña = scanner.nextLine();

        // Buscar espacio disponible en el array
        int index = buscarEspacioDisponible(usuarios);

        if (index != -1) {
            usuarios[index] = usuario;
            contraseñas[index] = contraseña;

            System.out.println("Usuario registrado exitosamente.");
        } else {
            System.out.println("No hay espacio disponible para registrar un nuevo usuario.");
        }
    }

    private static int buscarEspacioDisponible(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                return i;
            }
        }
        return -1; // Si no hay espacio disponible
    }

    private static void iniciarSesion() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inicio de Sesión");
        System.out.print("Ingrese su nombre de usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String contraseña = scanner.nextLine();

        int index = buscarUsuario(usuario, contraseña);

        if (index != -1) {
            System.out.println("Inicio de sesión exitoso.");
            mostrarDatosUsuario(index);
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
        }
    }

    private static int buscarUsuario(String usuario, String contraseña) {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null && usuarios[i].equals(usuario) && contraseñas[i].equals(contraseña)) {
                return i;
            }
        }
        return -1; // Si el usuario no se encuentra
    }

    private static void mostrarDatosUsuario(int index) {
        System.out.println("Datos del Usuario:");
        System.out.println("Nombre: " + datosEstudiantes[index][0]);
        System.out.println("Carrera: " + datosEstudiantes[index][1]);
        System.out.println("Edad: " + datosEstudiantes[index][2]);
    }
}
