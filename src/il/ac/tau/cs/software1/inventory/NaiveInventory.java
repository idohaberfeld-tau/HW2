package il.ac.tau.cs.software1.inventory;

/*
 * A simple array-based Inventory (Question 6).
 */
public class NaiveInventory implements Inventory {

	private static final int INITIAL_CAPACITY = 100;

	private Collectible[] collectibles;
	private int currentCount;

	public NaiveInventory() {
		this.collectibles = new Collectible[INITIAL_CAPACITY];
	}

	@Override
	public void collect(Collectible collectible) {
		if (currentCount == collectibles.length) 
		{
			Collectible[] newCollectibles = new Collectible[collectibles.length*2];
			for (int i = 0; i < currentCount; i++) {
				newCollectibles[i] = collectibles[i];
			}
			collectibles = newCollectibles;
		}
		collectibles[currentCount] = collectible;
		currentCount++;
	}

	@Override
	public float getTotalWeight() {
		float totalWeight = 0;
		for (int i = 0; i < currentCount; i++) 
		{
			if (collectibles[i] != null) {
				totalWeight += collectibles[i].getWeight();
			}
		}
		return totalWeight;
	}

	@Override
	public int getCurrentCount() {
		return currentCount;
	}

	// Returns the array of Collectibles that is stored in the field of this class
	public Collectible[] getCollArr() {
		return collectibles;
	}
}
