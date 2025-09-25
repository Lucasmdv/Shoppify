package org.stockify.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.stockify.model.enums.PaymentMethod;
import org.stockify.model.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transactions")
@Audited
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "payment_method")
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TransactionType type;


    @ManyToOne
    @JoinColumn(name = "store_id")
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private StoreEntity store;

    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL,orphanRemoval = true)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Set<DetailTransactionEntity> detailTransactions;

    @OneToOne(mappedBy = "transaction", cascade = CascadeType.ALL)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private PurchaseEntity purchase;

    @OneToOne(mappedBy = "transaction", cascade = CascadeType.ALL)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private SaleEntity sale;

    @PrePersist
    public void prePersist(){
        this.dateTime = LocalDateTime.now();
    }

}
