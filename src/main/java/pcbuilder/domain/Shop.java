package pcbuilder.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The Class Shop.
 */
@Entity
public class Shop implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true, nullable = false)
	private String name;
	private String url;
	private String logoUrl;

	/**
	 * Gets the id.
	 *
     * @return Long
     */
	public Long getId() {
		return id;
	}

	/**
	 * Gets the name.
	 *
     * @return String
     */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
     * @param name String
     */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the url.
	 *
     * @return String
     */
    @SuppressWarnings("unused")
    public String getUrl() {
		return url;
	}

	/**
	 * Sets the url.
	 *
     * @param url String
     */
    @SuppressWarnings("unused")
    public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Gets the logo url.
	 *
     * @return String
     */
    @SuppressWarnings("unused")
    public String getLogoUrl() {
		return logoUrl;
	}

	/**
	 * Sets the logo url.
	 *
     * @param logoUrl String
     */
    @SuppressWarnings("unused")
    public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

}
