package cn.cyuxuan.boot;

import com.sun.tools.attach.VirtualMachine;

public class AgentMain {
    public static void main(String[] args) throws Exception {
        //目标VM线程ID
        VirtualMachine target = VirtualMachine.attach("8072");

        target.loadAgent("D:\\c_root\\learn\\learn\\learn-java\\bee-code-test-field\\project-demo\\agent-demo\\target\\agent-demo-1.0-SNAPSHOT.jar");

        target.detach();
    }
}