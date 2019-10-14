package lianxi;

import java.util.List;

public class Solution57 {

    private static int solution(int totalDisk, int totalMemory, List<Service> services) {

        // TODO Write your code here

        int m=0;int n=0;
        for(int i=0;i<services.size();i++){
            for(int j=i;j<services.size();j++){
                if(services.get(i).disk+services.get(j).disk==totalDisk){
                    m=i;
                    n=j;
                }
            }
        }
      int p=0;int q=0;
        for(int i=0;i<services.size();i++){
            for(int j=i;j<services.size();j++){
                if(services.get(i).memory+services.get(j).memory==totalMemory){
                    p=i;
                    q=j;
                }
            }
        }

        return services.get(m).users+services.get(n).users>services.get(p).users+services.get(q).users?
                services.get(m).users+services.get(n).users:services.get(p).users+services.get(q).users;

    }
    static class Service {

        private int disk;

        private int memory;

        private int users;

        public Service(int disk, int memory, int users) {
            this.disk = disk;
            this.memory = memory;
            this.users = users;
        }

        public int getDisk() {
            return disk;
        }

        public void setDisk(int disk) {
            this.disk = disk;
        }

        public int getMemory() {
            return memory;
        }

        public void setMemory(int memory) {
            this.memory = memory;
        }

        public int getusers() {
            return users;
        }

        public void setusers(int users) {
            this.users = users;
        }
    }
}
