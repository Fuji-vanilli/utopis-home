export default [
  {
    context: [
      '/USER-SERVICE',
      '/PROPERTY-SERVICE',
      '/api', 
      '/oauth2', 
      '/login'
    ],
    target: 'http://localhost:8800',
    secure: true
  }
]
