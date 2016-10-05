package be.vdab.restservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import be.vdab.entities.Brouwer;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
class BrouwerResource extends ResourceSupport {
	@SuppressWarnings("unused")
	private Brouwer brouwer;

	BrouwerResource() { // JAXB heeft een default constructor nodig
	}

	BrouwerResource(Brouwer brouwer, EntityLinks entityLinks) {
		this.brouwer = brouwer;
		this.add(entityLinks.linkToSingleResource(Brouwer.class, brouwer.getId()));
	}
}