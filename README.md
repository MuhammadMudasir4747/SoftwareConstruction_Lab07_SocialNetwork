# Lab 07: Test-First Programming – Social Network

This project demonstrates **Test-First Programming (TDD)** in Java by implementing and testing a simple **social network analysis tool**.  
It infers relationships and influence among users based on Twitter-like data using two core methods:
- `guessFollowsGraph()` → builds a social graph from user mentions  
- `influencers()` → ranks users by their total number of followers  

---

##  Description
The lab focuses on designing, testing, and implementing methods that extract social relationships from tweets.  
Using **JUnit**, tests were written *before* the implementation to ensure each function met its specification and handled all edge cases.

This project helped reinforce:
- Unit testing and specification-driven design  
- Static checking and modular programming  
- Software engineering principles like reliability, clarity, and readiness for change  

---

##  Technologies Used
- **Java 17+**
- **JUnit 4**
- **Eclipse IDE**

---

##  Project Structure
Lab07_SocialNetwork/
└── src/
└── lab07/
├── Tweet.java
├── SocialNetwork.java
├── SocialNetworkTest.java
└── Main.java



---

##  How to Run

### 1. Clone the repository
```bash
git clone https://github.com/<your-username>/Lab07_SocialNetwork.git

2. Open in Eclipse

File → Import → Existing Projects into Workspace

Select the project folder

Add JUnit 4 to Build Path if not already included

3. Run JUnit Tests

Right-click SocialNetworkTest.java → Run As → JUnit Test

Ensure all test cases pass (green bar ✅)

4. Run Main Program

Right-click Main.java → Run As → Java Application

View output in the Console showing the social graph and top influencers.

Social Graph: {alice=[bob], bob=[charlie, dave], charlie=[alice]}
Influencers: [alice, bob, charlie, dave]




📜 License

This project is for educational purposes only.
Based on MIT OpenCourseWare 6.005/6.102 Problem Set 1: Inferring a Social Network.
---

Would you like me to make it **GitHub-optimized** (with emojis, badges, and a short “Quick Demo” GIF section if you upload screenshots)?


