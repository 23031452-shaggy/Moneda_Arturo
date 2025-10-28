import java.util.*;

class Usuario {
    private String id;
    private String nombre;
    private String email;
    private String telefono;
    public Usuario(String id, String nombre, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }
}

interface UsuarioRepository {
    void guardar(Usuario usuario);
    Usuario buscarPorId(String id);
    List<Usuario> obtenerTodos();
    boolean eliminar(String id);
}
class UsuarioRepositoryMemoria implements UsuarioRepository {
    private List<Usuario> usuarios = new ArrayList<>();

    @Override
    public void guardar(Usuario usuario) {
        usuarios.add(usuario);
    }
    @Override
    public Usuario buscarPorId(String id) {
        return usuarios.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<Usuario> obtenerTodos() {
        return new ArrayList<>(usuarios);
    }
    @Override
    public boolean eliminar(String id) {
        return usuarios.removeIf(u -> u.getId().equals(id));
    }
}

interface Notificador {
    void enviar(Usuario usuario, String mensaje);
}

class NotificadorBase implements Notificador {
    @Override
    public void enviar(Usuario usuario, String mensaje) {
    }
}

abstract class NotificadorDecorator implements Notificador {
    protected Notificador wrappee;
    public NotificadorDecorator(Notificador wrappee) {
        this.wrappee = wrappee;
    }
    @Override
    public void enviar(Usuario usuario, String mensaje) {
        wrappee.enviar(usuario, mensaje);
    }
}

class NotificadorEmail extends NotificadorDecorator {
    public NotificadorEmail(Notificador wrappee) { super(wrappee); }
    @Override
    public void enviar(Usuario usuario, String mensaje) {
        super.enviar(usuario, mensaje);
        System.out.println("Enviando EMAIL a " + usuario.getEmail() + ": " + mensaje);
    }
}
class NotificadorSMS extends NotificadorDecorator {
    public NotificadorSMS(Notificador wrappee) { super(wrappee); }
    @Override
    public void enviar(Usuario usuario, String mensaje) {
        super.enviar(usuario, mensaje);
        System.out.println("Enviando SMS a " + usuario.getTelefono() + ": " + mensaje);
    }
}
class NotificadorPush extends NotificadorDecorator {
    public NotificadorPush(Notificador wrappee) { super(wrappee); }
    @Override
    public void enviar(Usuario usuario, String mensaje) {
        super.enviar(usuario, mensaje);
        System.out.println("Enviando PUSH a " + usuario.getId() + ": " + mensaje);
    }
}
class NotificadorLog extends NotificadorDecorator {
    public NotificadorLog(Notificador wrappee) { super(wrappee); }
    @Override
    public void enviar(Usuario usuario, String mensaje) {
        super.enviar(usuario, mensaje);
        System.out.println("Log: Notificación enviada a " + usuario.getNombre());
    }
}
class NotificadorCifrado extends NotificadorDecorator {
    public NotificadorCifrado(Notificador wrappee) { super(wrappee); }
    @Override
    public void enviar(Usuario usuario, String mensaje) {
        super.enviar(usuario, mensaje);
        String cifrado = new StringBuilder(mensaje).reverse().toString();
        System.out.println("Mensaje cifrado: " + cifrado);
    }
}

class ServicioNotificaciones {
    private final UsuarioRepository repo;
    private final Notificador notificador;
    public ServicioNotificaciones(UsuarioRepository repo, Notificador notificador) {
        this.repo = repo;
        this.notificador = notificador;
    }
    public void enviarNotificacion(String idUsuario, String mensaje) {
        Usuario usuario = repo.buscarPorId(idUsuario);
        if (usuario == null) {
            System.out.println("Usuario no encontrado: " + idUsuario);
            return;
        }
        notificador.enviar(usuario, mensaje);
    }
    public void enviarNotificacionUrgente(String idUsuario, String mensaje) {
        Usuario usuario = repo.buscarPorId(idUsuario);
        if (usuario == null) {
            System.out.println("Usuario no encontrado: " + idUsuario);
            return;
        }
        notificador.enviar(usuario, "URGENTE: " + mensaje);
    }
}
public class SistemaNotificaciones {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA CON PATRONES (Decorator + Repository) ===");
        UsuarioRepository repo = new UsuarioRepositoryMemoria();
        Usuario u1 = new Usuario("1", "Juan Pérez", "juan@email.com", "+123456789");
        Usuario u2 = new Usuario("2", "María García", "maria@email.com", "+987654321");
        repo.guardar(u1);
        repo.guardar(u2);
        Notificador notificador =
                new NotificadorCifrado(
                        new NotificadorLog(
                                new NotificadorPush(
                                        new NotificadorSMS(
                                                new NotificadorEmail(
                                                        new NotificadorBase())))));
        ServicioNotificaciones servicio = new ServicioNotificaciones(repo, notificador);
        System.out.println("\n--- Notificación normal ---");
        servicio.enviarNotificacion("1", "Bienvenido al sistema");
        System.out.println("\n--- Notificación urgente ---");
        servicio.enviarNotificacionUrgente("2", "Su cuenta está por expirar");
        System.out.println("\n--- Usuario no encontrado ---");
        servicio.enviarNotificacion("3", "Mensaje de prueba");
    }
}
