//
//  PlacesViewController.swift
//  Sofia Swing Dance Festival
//
//  Created by Slav Sarafski on 5/18/16.
//  Copyright © 2016 Spirit Invoker. All rights reserved.
//

import UIKit
import GoogleMaps
import AFOAuth2Manager

class PlacesViewController: UIViewController, CLLocationManagerDelegate, UITableViewDelegate, UITableViewDataSource {

    @IBOutlet weak var mapView: GMSMapView!
    @IBOutlet weak var talbeView: UITableView!
    var locationManager = CLLocationManager()
    
    override func viewDidLoad() {
        super.viewDidLoad()

//        let iv:UIImageView = UIImageView (image: UIImage(named: "Logo"))
//        iv.frame.size.width = 40
//        iv.frame.size.height = 40
//        iv.contentMode = .ScaleAspectFit
//        self.navigationItem.titleView = iv
        
        self.navigationItem.title = "Swing Aout"
        
        let camera = GMSCameraPosition.cameraWithLatitude(42.6847251, longitude: 23.3189384, zoom: 15)
        mapView.camera = camera
        mapView.settings.myLocationButton = true
        mapView.myLocationEnabled = true
        
        locationManager.delegate = self;
        locationManager.desiredAccuracy = kCLLocationAccuracyBest
        locationManager.requestWhenInUseAuthorization()
        locationManager.startUpdatingLocation()
        
        loadLocations()
    }
    
    func locationManager(manager: CLLocationManager, didChangeAuthorizationStatus status: CLAuthorizationStatus) {
        if status == CLAuthorizationStatus.AuthorizedWhenInUse {
            mapView.myLocationEnabled = true
            mapView.settings.myLocationButton = true
        }
    }
    
    var markers:[GMSMarker] = []
    func createMarkers () {
        markers = []
        for loc in locations {
            let position = CLLocationCoordinate2DMake(loc.lat, loc.lon)
            let marker = GMSMarker(position: position)
            marker.title = loc.title
            marker.snippet = loc.text
            marker.map = mapView
            markers.append(marker)
        }
        
    }
    
    var locations:[Location] = []
    let baseURL = NSURL(string: "http://swingaout.lekov.me")
    func loadLocations () {
        let manager:AFHTTPSessionManager = AFHTTPSessionManager(baseURL: baseURL)
        manager.requestSerializer.setAuthorizationHeaderFieldWithCredential(AFOAuthCredential.retrieveCredentialWithIdentifier("credential"))
        
        manager.GET("/events/1/guide/",
                    parameters: nil,
                    progress: { (pro) in
                        
            }, success: { (task, res) in
                let json = JSON(res!)
                                print("daaa \(json)")
                for (_, item) in json["features"] {
                    self.locations.append(Location (item: item))
                }
                self.createMarkers()
                self.talbeView.reloadData()
        }) { (task, error) in
            print ("neee \(error)")
        }
    }
    
    func numberOfSectionsInTableView(tableView: UITableView) -> Int {
        return 1
    }

    
    func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return locations.count
    }
    
    func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        let cell:LocationCellTableViewCell = tableView.dequeueReusableCellWithIdentifier("locationsIdentifier", forIndexPath: indexPath) as! LocationCellTableViewCell
        
        cell.titleLabel!.text = locations[indexPath.row].title
        cell.descrionLabel!.text = locations[indexPath.row].text
        cell.button!.tag = indexPath.row
        cell.button!.addTarget(self, action: #selector(gotoGoogleMap(_:)), forControlEvents: .TouchUpInside)
        
        return cell
    }
    
    func tableView(tableView: UITableView, didSelectRowAtIndexPath indexPath: NSIndexPath) {
        let camera = GMSCameraPosition.cameraWithLatitude(locations[indexPath.row].lat, longitude: locations[indexPath.row].lon, zoom: mapView.camera.zoom)
        mapView.camera = camera
        mapView.selectedMarker = markers[indexPath.row]
    }
    
    func gotoGoogleMap(sender: AnyObject) {
        if (UIApplication.sharedApplication().canOpenURL(NSURL(string:"comgooglemaps://")!)) {
            if let navAdd = NSURL(string:"comgooglemaps://?saddr=Current+Location&daddr=\(locations[sender.tag].lat),\(locations[sender.tag].lon)&directionsmode=walking") {
                UIApplication.sharedApplication().openURL(navAdd)
            }
            print ("loc \(locations[sender.tag].lon)")
//            UIApplication.sharedApplication().openURL(NSURL(string:"google.com")!)
        } else {
            print("Can't use comgooglemaps://");
        }

    }
}
