package Service;

import DomainEntity.Filme;
import Exception.BusinessException;
import Repository.FilmeRepository;
import java.util.List;

public class FilmeService {
    
    public FilmeService(){
        this.repository = new FilmeRepository();
    }
    
    private FilmeRepository repository;
    
    public Filme obter(int id){
        return this.repository.obter(id);
    }
    
    public Filme obter(String nome){
        return this.repository.obter(nome);
    }
    
    public void salvar(Filme filme) throws BusinessException{
        if(filme == null)
            throw new BusinessException("Filme não informado!");
        
        Filme filmeMesmoNome = this.obter(filme.getNome());
        
        if(filmeMesmoNome != null)
            throw new BusinessException("Filme já existe!");
        
        this.repository.Insert(filme);
    }
    
    public List<Filme> obterTodos(){
        return this.repository.listar();
    }
    
    public void remover(Filme filme){
        this.repository.Delete(filme);
    }
}
