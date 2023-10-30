package fr.livar.mtg.mtgdecklist.persistence.model;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@IdClass(RelatedCard.class) 
@Table(name = "relatedCard")
public class RelatedCard {
	@Id @ManyToOne(cascade = CascadeType.MERGE) private Card sourceCardId;
	@Id @ManyToOne(cascade = CascadeType.MERGE) private Card targetCardId;
	private String relationType;
	
	public RelatedCard() {}
	public RelatedCard(Card sourceCardId, Card targetCardId, String relationType) {
		this.sourceCardId = sourceCardId;
		this.targetCardId = targetCardId;
		this.relationType = relationType;
	}
	
	public Card getSourceCardId() {
		return sourceCardId;
	}
	public Card getTargetCardId() {
		return targetCardId;
	}
	public String getRelationType() {
		return relationType;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(relationType, sourceCardId, targetCardId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RelatedCard other = (RelatedCard) obj;
		return Objects.equals(relationType, other.relationType) && Objects.equals(sourceCardId, other.sourceCardId)
				&& Objects.equals(targetCardId, other.targetCardId);
	}
}
