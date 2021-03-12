package com.cg.sprint1_onlineplantnursery.repository;

import java.util.List;

import javax.persistence.*;

import com.cg.sprint1_onlineplantnursery.entity.Planter;

public class IPlanterRepositoryImpl implements IPlanterRepository{
	
	EntityManagerFactory factory =  Persistence.createEntityManagerFactory("OnlinePlanterNursery");
	EntityManager em  =  factory.createEntityManager();

	@Override
	public Planter addPlanter(Planter planter) {
		if (em.find(Planter.class, planter.getPlanterId()) == null) {
			em.getTransaction().begin();
			em.persist(planter);
			em.getTransaction().commit();
		}
		
		return planter;
	}

	@Override
	public Planter updatePlanter(Planter planter) {
		Planter p = em.find(Planter.class, planter.getPlanterId());
		em.getTransaction().begin();
		p.setPlanterShape("Rectangle"); //Hard coded for now
		em.getTransaction().commit();
		return em.find(Planter.class, planter.getPlanterId());
	}

	@Override
	public Planter deletePlanter(Planter planter) {
		Planter p = em.find(Planter.class, planter.getPlanterId());
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		return planter;
	}

	@Override
	public Planter viewPlanter(int planterId) {
		
		return em.find(Planter.class, planterId);
	}

	@Override
	public Planter viewPlanter(String planterShape) {
		Query query = em.createQuery("select p from Planter p where p.planterShape = planterShape");
		List<Planter> planters = query.getResultList();
		if (planters.size() != 0)
			return planters.get(0);
		return null;
	}

	@Override
	public List<Planter> viewAllPlanters() {
		Query query  = em.createQuery("Select p from Planter p");
		List<Planter> planters;
		planters = query.getResultList();
		return planters;
	}

	@Override
	public List<Planter> viewAllPlanters(double minCost, double maxCost) {
		TypedQuery<Planter> query = (TypedQuery<Planter>) em.createQuery("select p from Planter p where p.planterCost between :minCost and :maxCost");
		List<Planter> selectedPlanters;
		selectedPlanters = query.setParameter("minCost",(int)minCost).setParameter("maxCost", (int)maxCost).getResultList();
		return selectedPlanters;
	}

}
