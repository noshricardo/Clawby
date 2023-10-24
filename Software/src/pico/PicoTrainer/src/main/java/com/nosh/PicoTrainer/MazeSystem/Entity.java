package com.nosh.PicoTrainer.MazeSystem;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.texture.Texture;



public class Entity {
	
	String name;	
	float[] pos;
	int modelIndex;
	int faceing;
	float size;
	float[] color;
	int type;
        float scale = 8;
	
	Geometry geom;
	
	public Entity(float x, float y, float z, float size, float[] color, String name, int direction, int type) {
		pos = new float[]{
				x, y, z
		};
		this.size = size;
		this.name = name;
		this.color = color;
		faceing = direction;
		this.type = type;
                
	}
	
	public void updateModel() {
		
	}
	
	public void setModel(AssetManager assetManager, Node rootNode) {
		Box box = new Box(1*scale,1*scale,1*scale);
                geom = new Geometry("Box", box);
                Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
                //Texture backrooms = assetManager.loadTexture("Textures/wall.jpg");
                //mat.setTexture("ColorMap", backrooms);
                mat.setColor("Color", ColorRGBA.Yellow);
                geom.setLocalTranslation((pos[0]*2f*scale)-1000,5,(pos[1]*2f*scale)-1000);
                geom.setMaterial(mat);
                rootNode.attachChild(geom);
	}	
	
}
