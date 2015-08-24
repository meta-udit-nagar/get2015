 
public class Graph implements Connection{

    @Override
    public void addConnection(Entity e1, Entity e2) {
        e1.friends.add(e2.email);
        e2.friends.add(e1.email);
        
    
    
    }

    @Override
    public void removeConnection(Entity e1, Entity e2) {
    e1.friends.remove(e2.email);
    e2.friends.remove(e1.email);
    }

    @Override
    public String findFriend(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
