package com.techverse.main.service;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.techverse.main.objects.UserDetails;

@Service
public class FirebaseService {
	public String saveUserDetails(UserDetails userDetails) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture  = dbFirestore.collection("users").document(userDetails.getEmail()).set(userDetails);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}
	
	public UserDetails getUserDetails(String email) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference  documentReference = dbFirestore.collection("users").document(email);
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		
		DocumentSnapshot document = future.get();
		
		UserDetails userDetails = null;
		
		if(document.exists()) {
			userDetails = document.toObject(UserDetails.class);
			return userDetails;
		}else {
			return null;
		}
		
	}
	
	public String updateUserDetails(UserDetails userDetails) throws InterruptedException, ExecutionException  {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture  = dbFirestore.collection("users").document(userDetails.getEmail()).set(userDetails);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}

	
	public String deleteUser(String email) {
		
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture  = dbFirestore.collection("users").document(email).delete();
		return "Document with id "+email+" has been deleted";
	
		
	}
	
}
