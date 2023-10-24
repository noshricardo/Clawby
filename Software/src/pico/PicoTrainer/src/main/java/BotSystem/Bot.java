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
    float dist1 = 0;
    float dist2 = 0;
    float dist3 = 0;
    
    
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
        Ray ray1 = new Ray(this.getLocation(), new Vector3f(1,1,1));
        Ray ray2 = new Ray(this.getLocation(), new Vector3f(1,1,1));
        Ray ray3 = new Ray(this.getLocation(), new Vector3f(1,1,1));
        //Geometry r = new Geometry();
        CollisionResults results1 = new CollisionResults();
        CollisionResults results2 = new CollisionResults();
        CollisionResults results3 = new CollisionResults();
        rootNode.collideWith(ray1, results1);
        rootNode.collideWith(ray2, results2);
        rootNode.collideWith(ray3, results3);
        dist1 = results1.getClosestCollision().getDistance();
        dist2 = results2.getClosestCollision().getDistance();
        dist3 = results3.getClosestCollision().getDistance();
    }
    
}
