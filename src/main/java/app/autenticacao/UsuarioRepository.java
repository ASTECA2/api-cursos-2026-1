package app.autenticacao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByNomeDeUsuario(String nomeDeUsuario);
}