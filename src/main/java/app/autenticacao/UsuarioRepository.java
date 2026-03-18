package app.autenticacao;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByNomeDeUsuario(String nomeDeUsuario);
}