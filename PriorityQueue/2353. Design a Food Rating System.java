class FoodRatings {

    private Map<String, PriorityQueue<Food>> map;
    private Map<String, Food> foodMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        map = new HashMap<>();
        foodMap = new HashMap<>();
        for (int i = 0; i < foods.length; i ++) {
            Food food = new Food(foods[i], cuisines[i], ratings[i]);
            map.putIfAbsent(cuisines[i], new PriorityQueue<>((a, b) -> a.rating == b.rating ? a.foodName.compareTo(b.foodName) : Integer.compare(b.rating, a.rating)));
            PriorityQueue<Food> pq = map.get(cuisines[i]);
            pq.offer(food);
            foodMap.put(foods[i], food);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Food curFood = foodMap.get(food);
        map.get(curFood.cuisine).remove(curFood);
        curFood.rating = newRating;
        map.get(curFood.cuisine).offer(curFood);
        foodMap.put(food, curFood);
        
    }
    
    public String highestRated(String cuisine) {
        return map.get(cuisine).peek().foodName;
        
    }
}

class Food {
    // I should use private types and getter/setter
    // just lazy...
    String foodName;
    String cuisine;
    int rating;
    public Food() {}
    public Food(String foodName, String cuisine, int rating) {
        this.foodName = foodName;
        this.cuisine = cuisine;
        this.rating = rating;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
