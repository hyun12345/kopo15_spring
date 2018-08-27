package kr.ac.kopo.danjiresort.web.user;
//package kr.ac.kopo.board.web.user;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import kr.ac.kopo.board.domain.User;
//import kr.ac.kopo.board.service.UserService;
//
//@RestController
//public class UserRestController {
//	
////	private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);
////	
////	@Autowired
////	private UserService userService;
////	
////	
////	//-------------------Retrieve All Users--------------------------------------------------------
////    @RequestMapping(value = "/api/user/all", method = RequestMethod.GET)
////    public ResponseEntity<List<User>> listAllUsers() {
////        List<User> users = userService.selectAll();
////        if(users.isEmpty()){
////            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
////        }
////        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
////    }
//// 
////    
////    //-------------------Retrieve Single User--------------------------------------------------------
////    @RequestMapping(value = "/api/user/one/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
////    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
////    	logger.info("Fetching User with id " + id);
////        User user = userService.selectOne(id);
////        if (user == null) {
////        	logger.info("User with id " + id + " not found");
////            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
////        }
////        return new ResponseEntity<User>(user, HttpStatus.OK);
////    }
//// 
////    
////    //-------------------Create a User--------------------------------------------------------
////    @RequestMapping(value = "/api/user/one", method = RequestMethod.POST)
////    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
////        logger.info("Creating User " + user.getName());
//// 
////        if (userService.isUserExist(user)) {
////            logger.info("A User with name " + user.getName() + " already exist");
////            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
////        }
//// 
////        userService.createOne(user);
//// 
////        HttpHeaders headers = new HttpHeaders();
////        headers.setLocation(ucBuilder.path("/api/user/one/{id}").buildAndExpand(user.getId()).toUri());
////        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
////    }
//// 
////     
////    //------------------- Update a User --------------------------------------------------------
////    @RequestMapping(value = "/api/user/one/{id}", method = RequestMethod.PUT)
////    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
////        logger.info("Updating User " + id);
////         
////        User currentUser = userService.selectOne(id);
////         
////        if (currentUser==null) {
////            logger.info("User with id " + id + " not found");
////            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
////        }
//// 
////        currentUser.setName(user.getName());
////        currentUser.setEmail(user.getEmail());
////        currentUser.setPassword(user.getPassword());
////         
////        userService.updateOne(currentUser);
////        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
////    }
//// 
////    
////    //------------------- Delete a User --------------------------------------------------------
////    @RequestMapping(value = "/api/user/one/{id}", method = RequestMethod.DELETE)
////    public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
////        logger.info("Fetching & Deleting User with id " + id);
//// 
////        User user = userService.selectOne(id);
////        if (user == null) {
////            logger.info("Unable to delete. User with id " + id + " not found");
////            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
////        }
//// 
////        userService.deleteOne(id);
////        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
////    }
//// 
////     
////    //------------------- Delete All Users --------------------------------------------------------
////    @RequestMapping(value = "/api/user/all", method = RequestMethod.DELETE)
////    public ResponseEntity<User> deleteAllUsers() {
////        System.out.println("Deleting All Users");
//// 
////        userService.deleteAll();
////        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
////    }
//	
//}
