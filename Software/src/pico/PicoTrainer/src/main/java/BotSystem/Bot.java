/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BotSystem;

import com.jme3.asset.AssetManager;
import com.jme3.collision.CollisionResults;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Ray;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;

/**
 *
 * @author nosh
 */
public class Bot {
    
    Geometry geom;
    float scale = 4;
    
    
    public Bot(Node rootNode, AssetManager assetManager){
        Box box = new Box(2*scale,1*scale,1*scale);
        geom = new Geometry("Box", box);
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Red);
        //geom.setLocalTranslation((pos[0]*2f*scale)-1000,5,(pos[1]*2f*scale)-1000);
        geom.setMaterial(mat);
        rootNode.attachChild(geom);
    }
    
    
    public Vector3f getLocation(){
        return geom.getLocalTranslation();
    }
    
    public void castRays(Node rootNode){
        Ray ray = new Ray(this.getLocation(), new Vector3f(1,1,1));
        //Geometry r = new Geometry();
        CollisionResults results = new CollisionResults();
        rootNode.collideWith(ray, results);
        String targetName = new String();
        try{
            targetName = results.getClosestCollision().getGeometry().getName();
        }catch(Exception e){
            
        }
    }
    
}
