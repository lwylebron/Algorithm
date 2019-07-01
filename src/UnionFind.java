//并查集
/**
 * N个人要坐在桌子上吃饭，但是人们拒绝和陌生人坐在一张桌子上。
 * 什么样的不算陌生人呢？主要是朋友的朋友的朋友的.....只要能扯上关系就不算陌生人。
 * 能扯上关系就可以坐在一张桌子上。所以至少要准备多少张桌子？
 *
 *
 * 思路：其实就是对并查集进行合并操作，只要俩人认识，就组队。
 * 把队组好以后，看最后有多少个组(集合)就行了。最初每个人都自成一组，所以有多少人就有多少组。
 * 但是随着他们组队，每两个组合并成一个组，总的组数就会少1。
 * 如果组队的时候发现，他俩已经早就‘扯上关系了’，也就表明他俩早就是一组了，那就不用继续合并了，也就不用再 -1 了。
 * */
public class UnionFind {

    private int[] parent;
    private int[] weight;
    private int size;//代表并查集中元素个数
    private int groups;//代表并查集中有多少个集合（小组）

    public UnionFind(int size) {
        this.parent = new int[size];
        this.weight = new int[size];
        this.size = size;
        this.groups = size;//因为初始的时候每个人自成一组，所以有多少人就有多少组
        for (int i = 0; i < size; i++) {
            this.parent[i] = i;
            this.weight[i] = 1;
        }
    }

    public int find(int element) {
        while (element != parent[element]) {
            parent[element] = parent[parent[element]];
            element = parent[element];
        }
        return element;
    }

    public boolean isConnected(int firstElement, int secondElement) {
        return find(firstElement) == find(secondElement);
    }

    public void unionElements(int firstElement, int secondElement) {
        int firstRoot = find(firstElement);
        int secondRoot = find(secondElement);

        //如果已经属于同一个集合了，就不用再合并了。
        if (firstRoot == secondRoot) {
            return;
        }

        if (weight[firstRoot] > weight[secondRoot]) {
            parent[secondRoot] = firstRoot;
            weight[firstRoot] += weight[secondRoot];
        } else {//weight[firstRoot] <= weight[secondRoot]
            parent[firstRoot] = secondRoot;
            weight[secondRoot] += weight[firstRoot];
        }

        //合并 firstElement 和 secondElement 所在的两个组后，就少了一组。
        this.groups--;
    }

    public int getGroups() {
        return this.groups;
    }



    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int times = scanner.nextInt();
        for (int i = 0; i < times; i++) {
            int size = scanner.nextInt();
            UnionFind union = new UnionFind(size);
            int input = scanner.nextInt();
            for (int j = 0; j < input; j++) {
                //因为测试数据是从1开始，而我们的并查集是从数组的第0位开始
                int first = scanner.nextInt() - 1;
                int second = scanner.nextInt() - 1;
                union.unionElements(first, second);
            }
            System.out.println(union.getGroups());
        }
    }
}
