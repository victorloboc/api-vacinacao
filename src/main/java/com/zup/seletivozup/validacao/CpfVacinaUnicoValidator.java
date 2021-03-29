package com.zup.seletivozup.validacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.zup.seletivozup.modelo.Usuario;

public class CpfVacinaUnicoValidator implements ConstraintValidator<CpfVacinaUnico, String>{
	
	private String campo;
	private Class<?> entidade;
	private Class<?> entidade2;
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void initialize(CpfVacinaUnico parametro) {
		this.campo = parametro.campo();
		this.entidade = parametro.entidade();
		this.entidade2 = Usuario.class;
	}
	
	@Override
	public boolean isValid(String valor, ConstraintValidatorContext cxt) {
		
		String jpql = "select 1 from "+entidade.getName()+" v inner join "+entidade2.getName()+" u on v.usuario = u.id where "+ campo +" =:valor";
		Query query = em.createQuery(jpql);
		query.setParameter("valor", valor);
		List<?> lista = query.getResultList();
		
		return lista.isEmpty();
		
	}
	
}