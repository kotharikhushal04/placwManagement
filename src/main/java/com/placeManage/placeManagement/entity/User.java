package com.placeManage.placeManagement.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        @Column(name = "user_id")
        private String id;
        private  String name;
        private String password;
        private String email;
        private String role;
        @OneToMany(mappedBy = "owner")
        private List<Ticket> ticketList;

        public User(String name, String email, String password, String role) {
                this.name = name;
                this.password = password;
                this.email = email;
                this.role = role;
        }
        public User() {
        }
        @Override
        public String toString() {
                return "User{" +
                        "id='" + id + '\'' +
                        ", name='" + name + '\'' +
                        ", password='" + password + '\'' +
                        ", email='" + email + '\'' +
                        ", role='" + role + '\'' +
                        ", ticketList=" + ticketList +
                        '}';
        }

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getRole() {
                return role;
        }

        public void setRole(String role) {
                this.role = role;
        }

        public List<Ticket> getTicketList() {
                return ticketList;
        }

        public void setTicketList(List<Ticket> ticketList) {
                this.ticketList = ticketList;
        }

        public User(String id, String name, String password, String email, String role, List<Ticket> ticketList) {
                this.id = id;
                this.name = name;
                this.password = password;
                this.email = email;
                this.role = role;
                this.ticketList = ticketList;
        }


}

