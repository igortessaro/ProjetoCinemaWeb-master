package Service;

import DomainEntity.Ingresso;
import Exception.BusinessException;
import Repository.IngressoRepository;
import java.util.Date;
import java.util.List;

public class VendaService {
    public VendaService(){
        this.repository = new IngressoRepository();
    }
    
    private IngressoRepository repository;
    
    public Ingresso obter(int id){
        return this.repository.obter(id);
    }
    
    public void salvar(Ingresso entity) throws BusinessException{
        if(entity == null)
            throw new BusinessException("Ingresso não informado!");
        
        entity.setDataHoraCompra(new Date());
        
        this.repository.Insert(entity);
    }
    
    public List<Ingresso> obterTodos(){
        return this.repository.listar();
    }
    
    public void remover(Ingresso entity){
        this.repository.Delete(entity);
    }
}
