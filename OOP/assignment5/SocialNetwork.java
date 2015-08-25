package socialNetworking;

public class SocialNetwork extends Graph {

	public Entity searchEntityByName(String name) {

		Entity entity = (Entity) super.searchByName(name);

		return entity;
	}

	public void connect(Entity entity1, Entity entity2) {
		super.addEdge(entity1, entity2);
		entity1.getFriends().add(entity2);
		entity2.getFriends().add(entity1);

	}

	public void add(Entity entity) {
		super.addNode(entity);
	}

	public void remove(Entity entity) {

		super.removeNode(entity);
	}

	public void disconnect(Entity entity1, Entity entity2) {
		super.removeEdge(entity1, entity2);
		entity1.getFriends().remove(entity2);
		entity2.getFriends().remove(entity1);

	}

}
