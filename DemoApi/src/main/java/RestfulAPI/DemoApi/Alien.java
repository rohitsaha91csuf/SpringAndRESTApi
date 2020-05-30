package RestfulAPI.DemoApi;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Alien {
	private int id;
	private String name;
	private int score;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Alien [id=" + id + ", name=" + name + ", score=" + score + "]";
	}
	

}
