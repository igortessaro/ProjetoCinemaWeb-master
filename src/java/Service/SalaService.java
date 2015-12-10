package Service;

import DomainEntity.Sala;
import Exception.BusinessException;
import Repository.SalaRepository;
import java.util.List;

public class SalaService {
    public SalaService(){
        this.repository = new SalaRepository();
    }
    
    private SalaRepository repository;
    
    public Sala obter(int id){
        return this.repository.obter(id);
    }
    
    public Sala obterPorNumero(int numero){
        return this.repository.obterPorNumero(numero);
    }
    
    public void atualizar(Sala entity) throws BusinessException{
        if(entity == null)
            throw new BusinessException("Sala não informado!");
        
        this.repository.Update(entity);
    }
    
    public void salvar(Sala entity) throws BusinessException{
        if(entity == null)
            throw new BusinessException("Sala não informado!");
        
        Sala salaNumeroExistente = this.obterPorNumero(entity.getNumero());
        
        if(salaNumeroExistente != null)
            throw  new BusinessException("Sala já existente!");
        
        this.repository.Insert(entity);
    }
    
    public List<Sala> obterTodos(){
        return this.repository.listar();
    }
    
    public void remover(Sala entity){
        this.repository.Delete(entity);
    }
}
