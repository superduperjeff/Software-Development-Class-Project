

import java.awt.Color;
import java.lang.reflect.Field;

import org.dom4j.Element;
import org.w3c.dom.NodeList;

public class OntologyItem {
private String value;
private Color color;
private String colorName;
private String name;
private String word;
private boolean annotation=false;
private Element element;

	public OntologyItem(Element _element) {
		// TODO Auto-generated constructor stub
		element=_element;
		value=element.attributeValue("value");
		name=element.attributeValue("name");
		colorName=element.attributeValue("color");
		word=element.attributeValue("word");
		if(element.attributeValue("annotation")!=null){
			if(element.attributeValue("annotation").equals("true")){
				annotation=true;
			}
			else{
				annotation=false;
			}
		}
		try {
		    Field field = Class.forName("java.awt.Color").getField(colorName);
		    color = (Color)field.get(null);
		} catch (Exception e) {
		    color = Color.white; // Not defined
		}
		
	}
	
	public void ontologyDictionary(Element _element) {
		
         
	}
	public String getDictionary(){
	return word;
	}
	
	public void setDictionary(String word) {
		this.word = word;
	}
	public Element getElement(){
	return element;
}
	public String getValue(){
		return value;
	}
	public Color getColor(){
		return color;
	}
	public String getColorName(){
		return colorName;
	}
	public void setColorName(String _colorName){
		colorName = _colorName;
	}
	public String getName(){
		return name;
	}
	public String toString(){
		return name;
	}
	public boolean isAnnotation() {
		// TODO Auto-generated method stub
		return annotation;
	}
	public void setValue(String _value){
		value = _value;
	}
	

	//sets an OntologyItem color based on a String input
	public void setColor(String _color){
		if(_color == "black"){
			color = Color.black;
		}
		else if(_color == "blue"){
			color = Color.blue;
		}
		else if(_color == "cyan"){
			color = Color.cyan;
		}
		else if(_color == "gray"){
			color = Color.gray;
		}
		else if(_color == "green"){
			color = Color.green;
		}
		else if(_color == "magenta"){
			color = Color.magenta;
		}
		else if(_color == "orange"){
			color = Color.orange;
		}
		else if(_color == "pink"){
			color = Color.pink;
		}
		else if(_color == "red"){
			color = Color.red;
		}
		else{
			color = Color.yellow;
		}
		
	}
	
}
