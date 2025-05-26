package org.stockify.model.specification;

import org.springframework.data.jpa.domain.Specification;
import org.stockify.model.entity.ProviderEntity;


public class ProviderSpecification {

    public static Specification<ProviderEntity> byName(String name) {
        return (root,query, criteriaBuilder) ->
                name== null ? null : criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<ProviderEntity> byBusinessName(String businessName) {
        return (root, query, criteriaBuilder) ->
                businessName == null ? null : criteriaBuilder.like(root.get("businessName"), "%" + businessName + "%");
    }

    public static Specification<ProviderEntity> byTaxId(String taxId) {
        return (root, query, criteriaBuilder) ->
                taxId == null ? null : criteriaBuilder.equal(root.get("taxId"), taxId + "%");
    }

    public static Specification<ProviderEntity> byEmail(String email) {
        return (root, query, criteriaBuilder) ->
                email == null ? null : criteriaBuilder.like(root.get("email"), "%" + email + "%");
    }

    public static Specification<ProviderEntity> byPhone(String phone) {
        return (root, query, criteriaBuilder) ->
                phone == null ? null : criteriaBuilder.equal(root.get("phone"), phone + "%");
    }

    public static Specification<ProviderEntity> byActive(Boolean status) {
        return (root, query, criteriaBuilder) ->{
                if ( status == null ) {
                    return criteriaBuilder.isNotNull(root.get("active"));
                }  return criteriaBuilder.equal(root.get("active"), status);
        };
    }

    public static Specification<ProviderEntity> byId(Long id) {
        return (root, query, criteriaBuilder) ->
                id == null ? null : criteriaBuilder.equal(root.get("id"), id);
    }

    public static Specification<ProviderEntity> byTaxAddress(String taxAddress) {
        return (root, query, criteriaBuilder) ->
                taxAddress == null ? null : criteriaBuilder.like(root.get("taxAddress"), "%" + taxAddress + "%");
    }

}
