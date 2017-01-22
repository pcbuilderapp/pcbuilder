package pcbuilder.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The Class Shop.
 */
@Entity
public class Shop implements Serializable{

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/** The name. */
	@Column(unique = true, nullable = false)
	private String name;

	/** The url. */
	private String url;
	
	/** The logo url. */
	private String logoUrl;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the url.
	 *
	 * @param url 
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Gets the logo url.
	 *
	 * @return the logo url
	 */
	public String getLogoUrl() {
		return logoUrl;
	}

	/**
	 * Sets the logo url.
	 *
	 * @param logoUrl
	 */
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

}
