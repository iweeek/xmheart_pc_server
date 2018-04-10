package com.xmheart.frontend.controller;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import com.xmheart.model.HisDoctor;

public class SetTest {

//
//    public static void main(String[] args) {
//        Set<Person> persons = new HashSet<Person>();
//        Set<Person> persons2 = new HashSet<Person>();
//        Person p1 = new Person();
//        p1.setName("AA");
//        p1.setAge(20);
//        System.out.println(p1.hashCode());
//        persons.add(p1);
//        
//        Person p2 = new Person();
//        p2.setName("AA");
//        p2.setAge(25);
//        System.out.println(p2.hashCode());
//        persons.add(p2);
//        
//        p1 = new Person();
//        p1.setName("BB");
//        p1.setAge(20);
//        persons.add(p1);
//        
//        p1 = new Person();
//        p1.setName("AA");
//        p1.setAge(25);
//        persons.add(p1);
//        persons2.add(p1);
//        System.out.println(persons.toString());
//        
//        System.out.println(persons.contains(new Person("AA", 20)));
//        
//        boolean b = persons2.removeAll(persons);
//        System.out.println(b);
//        System.out.println(persons2);
////        HisDoctorComparator comparator = new HisDoctorComparator();
////        Set<HisDoctor> doctors = new TreeSet<HisDoctor>(comparator);
////        HisDoctor doc = new HisDoctor();
////        doc.setName("曹龙兴");
////        doc.setWorkType(1);
////        System.out.println(doc.hashCode());
////        doctors.add(doc);
////        
////        HisDoctor doc2 = new HisDoctor();
////        doc2.setName("曹龙兴");
////        doc2.setWorkType(2);
////        doctors.add(doc2);
////        System.out.println(doc2.hashCode());
////        System.out.println(doctors);
////        
////        doc2 = new HisDoctor();
////        doc2.setName("AA");
////        doc2.setWorkType(2);
////        doctors.add(doc2);
////        System.out.println(doc2.hashCode());
////        System.out.println(doctors);
////        
////        doc2 = new HisDoctor();
////        doc2.setName("AA");
////        doc2.setWorkType(1);
////        doctors.add(doc2);
////        System.out.println(doc2.hashCode());
////        System.out.println(doctors);
////        
////        doc2 = new HisDoctor();
////        doc2.setName("22");
////        doc2.setWorkType(2);
////        doctors.add(doc2);
////        System.out.println(doc2.hashCode());
////        System.out.println(doctors);
////        
//    }
//}
//
//class Person {
//    private String name;
//    private int age;
//    
//    public Person() {
//        super();
//    }
//
//    public String getName() {
//        return name;
//    }
//    
//    public Person(String name, int age) {
//        super();
//        this.name = name;
//        this.age = age;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//    public int getAge() {
//        return age;
//    }
//    public void setAge(int age) {
//        this.age = age;
//    }
//    @Override
//    public int hashCode() {
//        return this.name.hashCode() + this.age;
//    }
//    
//    @Override
//    public boolean equals(Object obj) {
//        if(obj == null) {
//            return false;
//        }
//        if (obj == this) {
//            return true;
//        }
//        if (!(obj instanceof Person)) {
//            return false;
//        }
//        Person p = (Person) obj;
//        return p.name.equals(this.name) && p.age == this.age;
//    }
//    
//    @Override
//    public String toString() {
//        return "Person [name=" + name + ", age=" + age + "]";
//    }
//    
    
    
}
