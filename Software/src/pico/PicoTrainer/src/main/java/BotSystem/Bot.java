/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BotSystem;

import com.jme3.asset.AssetManager;
import com.jme3.collision.CollisionResults;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Quaternion;
import com.jme3.math.Ray;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Line;

/**
 *
 * @author nosh
 */
public class Bot {
    
    Geometry geom;
    Material mat;
    float scale = 4;
    float dist1 = 0;
    float dist2 = 0;
    float dist3 = 0;
    
    
    public Bot(Node rootNode, AssetManager assetManager){
        Box box = new Box(2*scale,1*scale,1*scale);
        geom = new Geometry("Bot", box);
        mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Red);
        //geom.setLocalTranslation((pos[0]*2f*scale)-1000,5,(pos[1]*2f*scale)-1000);
        geom.setMaterial(mat);
        geom.getLocalRotation();
        geom.setLocalTranslation(-150*8, 0, 4);
        rootNode.attachChild(geom);
        castRays(rootNode);
    }
    
    public void update(float tpf){
        
    }
    
    
    
    public Vector3f getLocation(){
        return geom.getLocalTranslation();
    }
    
    public void castRays(Node rootNode){
        
        
        Ray ray1 = new Ray(this.getLocation().clone(), geom.getLocalRotation().clone().mult(new Vector3f(1,0,0)));
        //Ray ray2 = new Ray(this.getLocation().clone(), geom.getLocalRotation().clone().addLocal(new Quaternion().fromAngles(100.5f, 0, 0)).mult(new Vector3f(1,0,0)));
        //Ray ray3 = new Ray(this.getLocation().clone(), geom.getLocalRotation().clone().addLocal(new Quaternion().fromAngles(-100.5f, 0, 0)).mult(new Vector3f(1,0,0)));
        Ray ray2 = new Ray(this.getLocation().clone(), ray1.direction.clone().add(0, 0, 1));
        Ray ray3 = new Ray(this.getLocation().clone(), ray1.direction.clone().add(0,0,-1));
        
        
        
        Line line1 = new Line(ray1.origin, ray1.origin.add(ray1.direction.mult(1000)));
        Geometry we1 = new Geometry("ray1", line1);
        we1.setMaterial(mat);
        //rootNode.attachChild(we1);
        
        Line line2 = new Line(ray2.origin, ray2.origin.add(ray2.direction.mult(1000)));
        Geometry we2 = new Geometry("ray2", line2);
        we2.setMaterial(mat);
        //rootNode.attachChild(we2);
        
        Line line3 = new Line(ray3.origin, ray3.origin.add(ray3.direction.mult(1000)));
        Geometry we3 = new Geometry("ray3", line3);
        we3.setMaterial(mat);
        //rootNode.attachChild(we3);
        
        
        CollisionResults results1 = new CollisionResults();
        CollisionResults results2 = new CollisionResults();
        CollisionResults results3 = new CollisionResults();
        
        rootNode.collideWith(ray1, results1);
        rootNode.collideWith(ray2, results2);
        rootNode.collideWith(ray3, results3);
        
        
        if(results1 != null){
            dist1 = results1.getCollision(2).getDistance();
            System.out.println("dist1: " + dist1);
            //results1.getCollision(2).getGeometry().setMaterial(mat);
            //System.out.println(results1.getCollision(2).getGeometry().getName());
        }
        if(results2 != null){
            dist2 = results2.getCollision(1).getDistance();
            System.out.println("dist2: " + dist2);
            //results2.getCollision(1).getGeometry().setMaterial(mat);
        }
        if(results3 != null){
            dist3 = results3.getCollision(1).getDistance();
            System.out.println("dist3: " + dist3);
            //results3.getCollision(1).getGeometry().setMaterial(mat);
        }
        
        
    }
    
}
