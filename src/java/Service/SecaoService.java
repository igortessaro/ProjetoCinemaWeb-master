package Service;

import DomainEntity.Secao;
import Exception.BusinessException;
import Repository.SecaoRepository;
import java.util.List;

public class SecaoService {
    public SecaoService(){
        this.repository = new SecaoRepository();
    }
    
    private SecaoRepository repository;
    
    public Secao obter(int id){
        return this.repository.obter(id);
    }
    
    public void salvar(Secao entity) throws BusinessException{
        if(entity == null)
            throw new BusinessException("Sala não informado!");
        
        this.repository.Insert(entity);
    }
    
    public List<Secao> obterTodos(){
        return this.repository.listar();
    }
    
    public void remover(Secao entity){
        this.repository.Delete(entity);
    }
}
