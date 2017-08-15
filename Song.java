/** Definition of the class Song.
 * 
 * @author joshuapeterson
 *
 */
public class Song
{
	private String itemCode;
	private String description;
	private String artist;
	private String album;
	private double price;
/**Definition of the constructor.
 * 
 */
	public Song()
	{
		this.itemCode = "";
		this.description = "";
		this.artist = "";
		this.album = "";
		this.price = 0.0;
	}
/**Definition of the parameterized Constructor.
 * 
 * @param itemCode
 * @param description
 * @param artist
 * @param album
 * @param price
 */
	public Song(String itemCode, String description,
			String artist, String album, double price)
	{
		this.itemCode = itemCode;
		this.description = description;
		this.artist = artist;
		this.album = album;
		this.price = price;
	}

/** Definition of the method getItemCode().
 * 
 * @return
 */
	public String getItemCode()
	{
		return itemCode;
	}
/**Definition of the method setItemCode().
 * 
 * @param itemCode
 */
	public void setItemCode(String itemCode)
	{
		this.itemCode = itemCode;
	}
/**Definition of the method getDescription().
 * 
 * @return
 */
	public String getDescription()
	{
		return description;
	}
/**Definition of the method setDescription().
 * 
 * @param description
 */
	public void setDescription(String description)
	{
		this.description = description;
	}
/**Definition of the method getArtist().
 * 
 * @return
 */

	public String getArtist()
	{
		return artist;
	}
/**Definition of the method setArtist().
 * 
 * @param artist
 */
	public void setArtist(String artist)
	{
		this.artist = artist;
	}
/**Definition of the method getAlbum().
 * 
 * @return
 */
	public String getAlbum()
	{
		return album;
	}
/**Definition of the method setAlbum().
 * 
 * @param album
 */
	public void setAlbum(String album)
	{
		this.album = album;
	}
/**Definition of the method getPrice().
 * 
 * @return
 */
	public double getPrice()
	{
		return price;
	}
/**Definition of the method setPrice().
 * 
 * @param price
 */
	public void setPrice(double price)
	{
		this.price = price;
	}
/**Definition of the method toString().
 * 
 */
	public String toString()
	{
		return description;
	}
}